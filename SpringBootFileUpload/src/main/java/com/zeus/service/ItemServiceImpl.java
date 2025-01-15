package com.zeus.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zeus.domain.Item;
import com.zeus.mapper.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper mapper;

	@Override
	public List<Item> list() throws Exception {
		return mapper.list();
	}

	@Override
	public void regist(Item item) throws Exception {
		mapper.create(item);
	}

	@Override
	public Item read(Integer itemId) throws Exception {
		return mapper.read(itemId);
	}

	@Override
	public void modify(Item item) throws Exception {
		mapper.update(item);
	}

	@Override
	public void remove(Integer itemId) throws Exception {
		// 삭제 전 파일 경로 조회
	    String pictureUrl = mapper.getPicture(itemId); // 파일 경로 가져오기
	    if (pictureUrl != null) {
	        java.nio.file.Path path = java.nio.file.Paths.get(pictureUrl);
	        try {
	            java.nio.file.Files.deleteIfExists(path); // 파일 삭제
	        } catch (IOException e) {
	            e.printStackTrace(); // 삭제 실패 시 로그 출력
	        }
	    }
	    mapper.delete(itemId); // 데이터베이스에서 아이템 삭제
	    
	}

	@Override
	public String getPicture(Integer itemId) throws Exception {
		return mapper.getPicture(itemId);
	}
}