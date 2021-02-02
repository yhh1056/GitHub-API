package src;

import java.io.IOException;
import org.kohsuke.github.GitHubBuilder;

/**
 * @author yhh1056
 * @since 2021/02/02
 */
public class GitHubApplication {

    public static void main(String[] args) throws IOException {
        App app = new App(new GitHubBuilder());
        app.connect();
    }
}
