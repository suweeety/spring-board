package org.zerock.mapper;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Java Config
// @ContextConfiguration(classes = {org.zerock.config.RootConfig.class} )
@Log4j2
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	@Test
	public void testMapper() {
		log.info(mapper);
	}

	private Long[] bnoArr = {70L, 71L, 72L, 73L, 74L}; //부모객체 bno값 존재용

	@Test
	public void testCreate() { //bno가 있는 값을 확인하여 반복 더미데이터를 삽입
		IntStream.rangeClosed(1, 10).forEach(i -> {
			ReplyVO vo = new ReplyVO(); //빈객체 생성
			vo.setBno(bnoArr[i % 5]); //위에 만든 배열을 5로 나눈 나머지 값을 넣음
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("ksy" + i);
			
			mapper.insert(vo); //위에서 만든 더미객체를 mapper에서 insert작업을 한다.
				
				
				
		});
	}

}
