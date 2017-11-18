import com.cat.zsy.rest.util.FileUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

public class PathAndFileTest {

    private static final String base = "e:/upload";
    private final Path path = Paths.get(base, "./1", "./2", "3/4", "../5.txt");
    private final Path to = Paths.get(base, "copy.txt");

    @Test
    public void test1() throws Exception {
        System.out.println(path.normalize());
        FileUtils.createPath(path);
    }

    @Test
    public void test2() throws Exception {
        Files.copy(path, to);
    }

    @Test
    public void test22() throws Exception {
        Files.copy(path, to, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void test3() throws Exception {
        Files.delete(to);
    }

    @Test
    public void test4() throws Exception {
        Files.move(to, Paths.get(base, "move.txt"));
    }

    @Test
    public void test5() throws Exception {
        Files.walkFileTree(Paths.get("E:/logs"), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println(">>>>>>>>>>pre visit dir:" + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("-------------visit file: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("visit file failed: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("<<<<<<<<<<<<<<post visit directory: " + dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    @Test
    public void test6() throws Exception {
        Files.walkFileTree(Paths.get("E:/logs"), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                System.out.println(">>>>>>>>>>pre visit dir:" + dir);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("-------------visit file: " + file);
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                System.out.println("visit file failed: " + file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                System.out.println("<<<<<<<<<<<<<<post visit directory: " + dir);
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    @Test
    public void test7() throws Exception {
//        getDirectories(Paths.get("e:/")).forEach(path -> System.out.println(path.normalize()));
        getDirectories2(Paths.get("e:/")).forEach(path -> System.out.println(path.normalize()));
    }

    public List<Path> getDirectories(Path dir) throws IOException {
        final List<Path> result = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path aStream : stream) {
                result.add(dir.resolve(aStream));
            }
        }
        return result;
    }

    public List<Path> getDirectories2(Path dir) throws IOException {

        return StreamSupport.stream(Files.newDirectoryStream(dir).spliterator(), false).collect(toList());
    }

}
