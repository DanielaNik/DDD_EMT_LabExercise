package mk.ukim.finki.emt.votingmodule.service.forms;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.votingmodule.domain.models.ElectionID;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class ElectionForm {

    @NotNull
    private LocalDateTime startOfElection;

    @NotNull
    private Integer durationInMinutes;

    @Valid
    @NotEmpty
    private List<CandidateForm> formList = new ArrayList<>();
}
