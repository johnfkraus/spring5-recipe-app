package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Nullable
    @Override
    public Notes convert(NotesCommand command) {
        if (command == null) {
            return null;
        }
        Notes notes = new Notes();
        notes.setId(command.getId());
        notes.setRecipeNotes(command.getRecipeNotes());

        return notes;
    }
}
