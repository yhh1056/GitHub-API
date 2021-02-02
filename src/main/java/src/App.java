package src;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        this.gitHub = GitHub.connect();
        GHRepository repository = getRepository(ADDRESS);

        Participants participants = new Participants();
        /**
         * 테스트용 이슈를 3개 만듦
         */
        for (int index = 1; index <= 3; index++) {
            GHIssue issue = repository.getIssue(index);
            List<GHIssueComment> comments = issue.getComments();

            for (GHIssueComment comment : comments) {
                participants.addParticipant(comment.getUser().getName(), index);

            }
        }
    }

    private GHRepository getRepository(String address) throws IOException {
        return gitHub.getRepository(address);
    }
}
