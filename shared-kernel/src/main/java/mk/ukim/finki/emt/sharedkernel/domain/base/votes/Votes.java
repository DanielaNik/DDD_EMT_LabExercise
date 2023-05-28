package mk.ukim.finki.emt.sharedkernel.domain.base.votes;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Embeddable
@Getter
public class Votes implements ValueObject {
    private final int votes;

    protected Votes(){
        this.votes = 0;
    }

    public Votes(@NotNull int votes){
        this.votes = votes;
    }

    public Votes addVote(){
        return new Votes(this.votes + 1);
    }

    public Votes add(Votes votes) {
        return new Votes(this.votes + votes.votes);
    }
}
