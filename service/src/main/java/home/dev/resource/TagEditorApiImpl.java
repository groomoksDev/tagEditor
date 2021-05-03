package home.dev.resource;

import home.dev.dto.EditRequestDto;
import home.dev.model.EditRequest;
import home.dev.service.TagEditorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagEditorApiImpl implements TagEditorApi {
    private final TagEditorService tagEditor;
    private final MapperFactory mapperFactory;

    @Autowired
    public TagEditorApiImpl(TagEditorService tagEditor, MapperFactory mapperFactory){
        this.tagEditor = tagEditor;
        this.mapperFactory = mapperFactory;
    }

    @Tag(name = "name", description = "description")
    @Override
    public ResponseEntity<Boolean> getUpperName() {
        return ResponseEntity.ok(true);
    }

    @Override
    public ResponseEntity<Boolean> setUpperName(EditRequestDto editRequestDto) {
        mapperFactory.classMap(EditRequestDto.class, EditRequest.class);
        EditRequest editRequest = mapperFactory.getMapperFacade().map(editRequestDto,EditRequest.class);
        return ResponseEntity.ok(tagEditor.setUpperName(editRequest));
    }
}
