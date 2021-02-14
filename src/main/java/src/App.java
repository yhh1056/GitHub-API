package src;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

/**
 * @author yhh1056
 * @since 2021/02/02
 */
public class App {
    private static final String OAuthToken = "my-token";
    private static final String ADDRESS = "yhh1056/GitHub-API";

    private GitHubBuilder builder;
    private GitHub gitHub;

    public App(GitHubBuilder gitHubBuilder) {
        builder = gitHubBuilder;
    }

    public void connect() throws IOException {
        this.gitHub = builder.withOAuthToken(OAuthToken).build();
        System.out.println("=====");

        this.gitHub = GitHub.connect();
        GHRepository repository = getRepository(ADDRESS);
        System.out.println("=====");

        Map<String, Integer> attendance = new HashMap<>();
        for (int index = 1; index <= 3; index++) {
            GHIssue issue = repository.getIssue(index);
            List<GHIssueComment> comments = issue.getComments();

            for (GHIssueComment comment : comments) {
                final String name = comment.getUser().getName();

                if (attendance.containsKey(name)) {
                    int check = attendance.get(name);
                    attendance.put(name, check + 1);
                } else {
                    attendance.put(name, 1);
                }
            }
        }

        Map<String, Double> result = new HashMap<>();

        for (String username : attendance.keySet()) {
            double check = attendance.get(username);
            double per = check / 18 * 100;
            result.put(username, Math.round(per * 100) / 100.0);
        }

        System.out.println(result);
    }

    private GHRepository getRepository(String address) throws IOException {
        return gitHub.getRepository(address);
    }
}
