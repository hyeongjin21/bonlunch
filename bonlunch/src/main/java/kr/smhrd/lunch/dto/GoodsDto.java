package kr.smhrd.lunch.dto;

import kr.smhrd.lunch.entity.Goods;
import kr.smhrd.lunch.entity.GoodsDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoodsDto {
	
	private Integer id;
	private String name;
	private String price;
	private Boolean isNew;
	private Boolean isBest;
	private String main_thumb;
	
	// GoodsDetail 물품의 상세 정보 객체도 넣을 예정
	private GoodsDetail detail;
	// React에서 이중 객체의 형태로 반환하기를 바라기 때문에
	
//	private int goods_id;
//	private String sub_thumb;
//	private String txt;
//	private String summary;
	
	public static GoodsDto fromEntity(Goods goods) {
		GoodsDto dto = new GoodsDto();
        dto.setId(goods.getId());
        dto.setName(goods.getName());
        dto.setPrice(goods.getPrice());
        dto.setIsNew(goods.getIsNew());
        dto.setIsBest(goods.getIsBest());
        dto.setMain_thumb(goods.getMain_thumb());
		return dto;
	}
	
	public static GoodsDto fromEntity(Goods goods, GoodsDetail goodsDetail) {
		GoodsDto dto = fromEntity(goods);
		GoodsDetail detail = new GoodsDetail();
		detail.setSub_thumb(goodsDetail.getSub_thumb());
		detail.setSummary(goodsDetail.getSummary());
		detail.setTxt(goodsDetail.getTxt());
		dto.setDetail(detail);
		return dto;
	}
	
}
