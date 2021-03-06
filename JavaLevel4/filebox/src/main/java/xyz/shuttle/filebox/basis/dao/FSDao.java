package xyz.shuttle.filebox.basis.dao;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import xyz.shuttle.filebox.basis.model.files.FileServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

@Repository
public class FSDao {

    @Value("${filePath}")
    private String filePath;

    @Autowired
    private FileServiceImpl fileService;

    private String getUserDirectory(String username) {
        String userPath = String.join("",
                filePath,
                File.separator,
                username,
                File.separator);

        return Paths.get(userPath).toString();
    }

    public List<File> getFileList(@NonNull String username) {
        List<File> fileList = new LinkedList<>();
        try {
            Files.walkFileTree(Paths.get(getUserDirectory(username)), new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (fileService.findFileByName(username, file.getFileName().toString()))
                        fileList.add(file.toFile());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileList;
    }

    public File getFileByName(@NonNull String filename) {
        return getFileByNameAndUsername(
                SecurityContextHolder.getContext().getAuthentication().getName(),
                filename
        );
    }

    public File getFileByNameAndUsername(@NonNull String username, @NonNull String filename){
        return new File(
                String.join("",
                        getUserDirectory(username),
                        File.separator,
                        filename)
        );
    }

    public void initUserDirectory(@NonNull String username) throws IOException {
        String userPath = String.join("",
                filePath,
                File.separator,
                username,
                File.separator);
        if (Files.notExists(Paths.get(userPath)))
            Files.createDirectories(Paths.get(userPath));
    }

    public void delete(@NonNull String filename) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Files.delete(
                Paths.get(
                        String.join("",
                                getUserDirectory(username),
                                File.separator,
                                filename))
        );
    }
}