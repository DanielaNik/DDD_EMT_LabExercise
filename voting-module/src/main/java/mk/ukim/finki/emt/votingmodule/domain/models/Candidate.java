package mk.ukim.finki.emt.votingmodule.domain.models;

import jakarta.persistence.Entity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.sharedkernel.domain.base.votes.Votes;

@Entity
public class Candidate extends AbstractEntity<CandidateID> {
    private String name;
    private String lastname;
    private Votes votes;

    public Candidate(String name, String lastname){
        super(DomainObjectId.randomId(CandidateID.class));
        this.name = name;
        this.lastname = lastname;
        this.votes = new Votes(0);
    }

    protected Candidate() {
        super(DomainObjectId.randomId(CandidateID.class));
    }

    public Votes getVotes(){
        return votes;
    }


}
