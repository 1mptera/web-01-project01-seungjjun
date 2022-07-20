package utils;

import models.Post;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PostLoader {
  public List<Post> loadPosts() throws FileNotFoundException {
    List<Post> posts = new ArrayList<>();

    File file = new File("Post.csv");

    Scanner scanner = new Scanner(file);

    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      Post post = parsePost(line);
      posts.add(post);
    }
    return posts;
  }

  public void writePost(List<Post> posts) throws IOException {
    FileWriter fileWriter = new FileWriter("Post.csv");
    for (Post post : posts) {
      String line = post.toCsvRow();

      fileWriter.write(line + "\n");
    }
    fileWriter.close();
  }

  public Post parsePost(String post) {
    String[] postInformation = post.split(",");

    return new Post(
        postInformation[0],
        postInformation[1],
        postInformation[2],
        postInformation[3]);
  }
}
