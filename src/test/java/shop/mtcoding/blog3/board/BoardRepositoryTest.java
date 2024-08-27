package shop.mtcoding.blog3.board;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@DataJpaTest
@Import(BoardRepository.class)
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;


    @Test
    public void updateById_test(){
        int id =1 ;
        String title="제목1변경";
        String content="내용1변경";

        boardRepository.updateById(id,title,content);

        Board board = boardRepository.findById(id);
        System.out.println(board.getTitle());
        System.out.println(board.getContent());

    }


    @Test
    public void deleteById(){
        int id = 1;
        boardRepository.deleteById(id);
        boardRepository.findById(id);

    }




    @Test
    public void findById_test(){
        //given
        int id = 1;

        //when
        Board board = boardRepository.findById(id);

        //then
        Assertions.assertThat(board.getTitle()).isEqualTo("제목1");
        Assertions.assertThat(board.getContent()).isEqualTo("내용1");

    }



    @Test
    public void findAll_test(){
       List <Board> boardList = boardRepository.findAll();
        System.out.println(boardList.size());
        System.out.println(boardList.get(0).getTitle());
    }



    @Test
    public void save_test(){
        String title = "제목1";
        String content = "내용1";

        boardRepository.save(title, content);
    }


}
