package com.snack.services;

import com.snack.entities.Product;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ProductService {
    private String filePath = "D:\\ChallengesBeecrowd\\1038 - Snacks\\Java\\src\\main\\resources\\images\\";

    public Product getById(int id) {
        return null;
    }

    public boolean exists(int id) {
        return true;
    }

    private String getFileExtension(Path path) {
        String filename = path.getFileName().toString();
        int lastDotIndex = filename.lastIndexOf('.');

        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "";
        }

        return filename.substring(lastDotIndex + 1);
    }

    public boolean save(Product product) {
        Path path = Paths.get(product.getImage());

        Path destinationPath = Paths.get(String.format("%s%d.%s", filePath, product.getId(), getFileExtension(path)));

        if (Files.exists(path)) {
            try {
                Files.copy(path, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                product.setImage(destinationPath.toString());
                return true;
            } catch (IOException e) {
                return false;
            }
        }

        return false;
    }

    public void delete(int id, Product product) {

    }
}
