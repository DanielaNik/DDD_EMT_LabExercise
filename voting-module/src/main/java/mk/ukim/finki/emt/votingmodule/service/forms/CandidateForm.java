package mk.ukim.finki.emt.votingmodule.service.forms;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.sharedkernel.domain.base.votes.Votes;

@Data
public class CandidateForm {
    @NotNull
    private String name;

    @NotNull
    private String lastname;

    @Min(0)
    private Votes votes;
}
