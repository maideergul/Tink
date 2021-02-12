package com.works.usetink;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.works.usetink.entities.UserInfo;
import com.works.usetink.repositories.UserInfoRepository;
import com.works.usetink.utils.TinkDecryption;
import com.works.usetink.utils.TinkEncrypt;

@RestController
public class UserInfoRestController {

	final UserInfoRepository uRepo;	
	
	public UserInfoRestController(UserInfoRepository uRepo) {
		this.uRepo = uRepo;
	}
	
	@PostMapping("/infoInsert")
	public Map<String, Object> infoInsert(@RequestBody UserInfo info)
	{
		Map<String, Object> hm = new LinkedHashMap<>();
		
		UserInfo uinfo = info;
		uinfo.setCiphertext(TinkEncrypt.encrypt(info.getKey128Bit(), info.getCiphertext(), info.getAssociatedData()));
		hm.put("result", uRepo.saveAndFlush(uinfo));
		
		return hm;
	}
	
	@PostMapping("/infoSelect")
	public Map<String, Object> infoSelect(@RequestBody UserInfo info)
	{
		Map<String, Object> hm = new LinkedHashMap<>();
		
		UserInfo dbInfo = uRepo.decryptInfo(info.getUid(), info.getKey128Bit(), info.getAssociatedData());
		if(dbInfo != null)
		{
			hm.put("enc", TinkDecryption.decrypt(dbInfo.getKey128Bit(), dbInfo.getCiphertext(), dbInfo.getAssociatedData())); 
		}else
		{
			hm.put("result", null);
		}
		
		return hm;
	}
	
}