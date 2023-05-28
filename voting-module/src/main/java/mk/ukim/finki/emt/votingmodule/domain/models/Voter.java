package mk.ukim.finki.emt.votingmodule.domain.models;

import jakarta.persistence.Entity;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

@Entity
public class Voter extends AbstractEntity<VoterId> {
    private boolean hasVoted;

    protected Voter(@NonNull AbstractEntity<VoterId> source) {
        super(source);
    }

    protected Voter() {
        super(DomainObjectId.randomId(VoterId.class));
    }
}
