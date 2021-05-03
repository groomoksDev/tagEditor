package home.dev.resource;

import home.dev.dto.EditRequestDto;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "/tag-editor/")
@RequestMapping("/tag-editor")
public interface TagEditorApi {

    @GetMapping
    ResponseEntity<Boolean> getUpperName();

    @PutMapping
    ResponseEntity<Boolean> setUpperName(@RequestBody EditRequestDto editRequestDto);

}