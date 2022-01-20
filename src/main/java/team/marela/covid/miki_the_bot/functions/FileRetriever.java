package team.marela.covid.miki_the_bot.functions;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileRetriever {

    public File getFromResources(String fileName) throws IOException {
        return  new ClassPathResource(fileName).getFile();
    }
}
