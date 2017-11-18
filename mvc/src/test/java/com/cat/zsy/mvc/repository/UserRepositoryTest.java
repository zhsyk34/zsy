//package com.cat.zsy.mvc.repository;
//
//import com.cat.zsy.mvc.config.CustomObjectMapperFactory;
//import com.cat.zsy.mvc.domain.User;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Test;
//import org.springframework.data.domain.*;
//
//import java.util.List;
//import java.util.function.Supplier;
//import java.util.stream.Stream;
//
//import static java.util.stream.Collectors.toList;
//
//public class UserRepositoryTest extends InitContext {
//
//    private final ObjectMapper mapper = CustomObjectMapperFactory.objectMapper();
//
//    @Test
//    public void save() throws Exception {
//        User user = new User().setName("name").setSex("man");
//        System.out.println("save result:" + userRepository.save(user));
//    }
//
//    private class PersonSupplier implements Supplier<User> {
//        private int index = 0;
//
//        @Override
//        public User get() {
//            index++;
//            return new User().setName("name" + index).setSex("man" + index);
//        }
//    }
//
//    @Test
//    public void save2() throws Exception {
//        List<User> users = Stream.generate(new PersonSupplier()).limit(5).collect(toList());
//        System.out.println("save result:" + userRepository.saveAll(users));
//    }
//
//    @Test
//    public void findByName() throws Exception {
//        Pageable page = PageRequest.of(0, 10);
//        Page<User> users = userRepository.findByNameContains("1", page);
//        System.out.println(page);
//        System.out.println(mapper.writeValueAsString(users));
//    }
//}