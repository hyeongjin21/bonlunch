package kr.smhrd.lunch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.smhrd.lunch.dto.GoodsDto;
import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import kr.smhrd.lunch.repository.GoodsDetailRepository;
import kr.smhrd.lunch.repository.GoodsRepository;

@Service
public class GoodsService {

	// 특정 컴포넌트 찾지 못한다
	// 1. 내가 컴포넌트 만들었나
	// 2. AutoWired -> 작성이 되었는다
	// 3. 어노테이션 작성 되었는가

	@Autowired
	GoodsRepository goodsRepository;

	@Autowired
	GoodsDetailRepository goodsDetailRepository;

	public List<GoodsDto> getAllGoods() {

		// 1. 데이터 처리
		// 2. repository 호출
		List<Goods> result = goodsRepository.findAll();

		// 3. Controller 돌려줄 데이터 처리
		List<GoodsDto> list = new ArrayList<GoodsDto>();

		for (Goods g : result) {
			GoodsDto dto = new GoodsDto();
//			dto.setId(g.getId());
//			dto.setName(g.getName());
//			dto.setPrice(g.getPrice());
//			dto.setIsNew(g.getIsNew());
//			dto.setIsBest(g.getIsBest());
//			dto.setMain_thumb(g.getMain_thumb());
			list.add(dto.fromEntity(g));
		}
		return list;
	}

	public GoodsDto getGoodsDetail(int id) {

		Goods goods = goodsRepository.findById(id).get();
		GoodsDetail detail = goodsDetailRepository.findById(id).get();

		// 두 변수의 값이 null인 경우에는 null을 리턴
		if (goods == null || detail == null) {
			return null;
		}

		GoodsDto dto = new GoodsDto();

//		dto.fromEntity(goods, detail);
//		dto.setId(result.getId());
//		dto.setIsBest(result.getIsBest());
//		dto.setIsNew(result.getIsNew());
//		dto.setName(result.getName());
//		dto.setPrice(result.getPrice());
//		dto.setSub_thumb(detailResult.getSub_thumb());
//		dto.setSummary(detailResult.getSummary());
//		dto.setTxt(detailResult.getTxt());

		return dto.fromEntity(goods, detail);
	}

}
