package unittest;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.annotations.Test;

public class test1 {

    @InjectMocks
    Book book;

    @Mock
    Pages page;
    
    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        Book book = new Book();
        Page page = new Page();
    }

    @Test
    public void testPages34(){
        Mockito.when(page.writtenPages()).thenReturn(20);
        int no = book.getNoOfPages();
        System.out.println(no);
    }

}
