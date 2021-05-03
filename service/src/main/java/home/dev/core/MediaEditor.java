package home.dev.core;

import ealvatag.audio.AudioFile;
import ealvatag.audio.AudioFileIO;
import ealvatag.audio.exceptions.CannotReadException;
import ealvatag.audio.exceptions.CannotWriteException;
import ealvatag.audio.exceptions.InvalidAudioFrameException;
import ealvatag.tag.FieldKey;
import ealvatag.tag.Tag;
import ealvatag.tag.TagException;
import home.dev.model.EditRequest;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static ealvatag.tag.NullTag.INSTANCE;
import static home.dev.model.TagEditorAction.LOWER;
import static home.dev.model.TagEditorAction.UPPER;
import static java.util.Objects.requireNonNull;

@Component
public class MediaEditor {

    public Boolean editTeg(EditRequest editRequest) {
        final File folder = new File(editRequest.getFilePath());
        listFilesForFolder(folder)
                .forEach(path -> tagEdit(editRequest, path));
        return true;
    }

    private void tagEdit(EditRequest editRequest, String path) {
        try {
            FieldKey fieldKey = editRequest.getFieldKey();
            File inputFile = new File(editRequest.getFilePath() + path);
            AudioFile audioFile = AudioFileIO.read(inputFile);
            Tag tag = requireNonNull(audioFile).getTag().or(INSTANCE);

            if (UPPER == editRequest.getAction()) {
                tag.setField(fieldKey, tag.getValue(fieldKey).get().toUpperCase());
            } else if (LOWER == editRequest.getAction()) {
                tag.setField(fieldKey, tag.getValue(fieldKey).get().toLowerCase(Locale.ROOT));
            }

            audioFile.save();
        } catch (CannotWriteException | CannotReadException | TagException | InvalidAudioFrameException | IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> listFilesForFolder(final File folder) {
        List<String> fileNames = new ArrayList<>();
        for (final File fileEntry : requireNonNull(folder.listFiles())) {
            fileNames.add(fileEntry.getName());
        }
        return fileNames;
    }

}
