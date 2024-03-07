create sequence seq_board ; -- board 에서 사용할 자동번호 객체

create table tbl_board (
	bno number(10,0),
	title nvarchar2(200) not null,
	content nvarchar2(2000) not null,
	writer nvarchar2(50) not null,
	regdate date default sysdate,
	updatedate date default sysdate
);  -- board 테이블 생성

alter table tbl_board add constraint pk_board primary key (bno);
-- tbl_board 테이블에 규약이름으로 pk_board를 명명하고 bno를 기본키로 설정

insert into tbl_board (bno, title, content, writer) 
	values (seq_board.nextval, 'test title', 'test content', 'user00');
	
select * from tbl_board ;






