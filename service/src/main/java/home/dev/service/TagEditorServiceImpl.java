package home.dev.service;

import home.dev.core.MediaEditor;
import home.dev.model.EditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagEditorServiceImpl implements TagEditorService{
    private final MediaEditor mediaEditor;

    @Autowired
    public TagEditorServiceImpl(MediaEditor mediaEditor){
        this.mediaEditor = mediaEditor;
    }

    @Override
    public Boolean setUpperName(EditRequest editRequest) {
        return mediaEditor.editTeg(editRequest);
    }
}
