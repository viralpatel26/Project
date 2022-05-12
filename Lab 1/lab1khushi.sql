
CREATE SEQUENCE seq_movie_id
START WITH 20
INCREMENT BY 5;

select * from user_sequences;


select seq_movie_id.NEXTVAL from user_sequences;


INSERT INTO mm_movie
VALUES (seq_movie_id.NEXTVAL,'Lion King',3,50.00,8);


CREATE VIEW VW_MOVIE_RENTAL AS
select movie.movie_title, rental.rental_id, member.last
from mm_movie movie join mm_rental rental on movie.movie_id=rental.rental_id join mm_member member on rental.rental_id=member.member_id;


select * from vw_movie_rental;

CREATE PUBLIC SYNONYM m_type
	FOR mm_movie_type;
