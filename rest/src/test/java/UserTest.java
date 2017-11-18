import com.cat.zsy.rest.entity.Product;
import org.junit.Test;

public class UserTest {

    @Test
    public void test() throws Exception {
        for (int i = 0; i < 100; i++) {
            Product product = new Product();
        }
    }

    @Test
    public void test2() throws Exception {
        Product product;
        for (int i = 0; i < 100; i++) {
            product = new Product();
        }
    }
}
