package home.dev.model;

import ealvatag.tag.FieldKey;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.stereotype.Component;

@Component
@Schema(description = "Сущность пользователя")
public class EditRequest {
    @Schema(description = "Путь к файлу")
    String filePath;

    @Schema(description = "Поле которое нужно обработать")
    FieldKey fieldKey;

    @Schema(description = "Увеличить/Уменьшить")
    TagEditorAction action;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public FieldKey getFieldKey() {
        return fieldKey;
    }

    public void setFieldKey(FieldKey fieldKey) {
        this.fieldKey = fieldKey;
    }

    public TagEditorAction getAction() {
        return action;
    }

    public void setAction(TagEditorAction action) {
        this.action = action;
    }
}
