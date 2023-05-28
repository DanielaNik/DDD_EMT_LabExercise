package mk.ukim.finki.emt.votingmodule.domain.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.criteria.CriteriaBuilder;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.base.votes.Votes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Election extends AbstractEntity<ElectionID> {
    private LocalDateTime startOfElection;

    private Integer durationInMinutes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Candidate> candidateList;

    protected Election(){
        super(ElectionID.randomId(ElectionID.class));
    }

    public Election(LocalDateTime startOfElection, Integer durationInMinutes){
        super(ElectionID.randomId(ElectionID.class));
        this.startOfElection = startOfElection;
        this.durationInMinutes = durationInMinutes;
    }

    public Votes total(){
        return this.candidateList.stream().map(c -> c.getVotes()).reduce(new Votes(0),Votes::add);
    }

    public Candidate addCandidate(String name, String lastname){
        var candidate = new Candidate(name,lastname);
        candidateList.add(candidate);
        return candidate;
    }

    public void removeCandidate(CandidateID candidateId){
        Objects.requireNonNull(candidateId,"Candidate to delete must not be null");
        candidateList.removeIf(v->v.getId().equals(candidateId));
    }
}
