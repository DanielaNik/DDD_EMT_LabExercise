package mk.ukim.finki.emt.votingmodule.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.votingmodule.domain.models.CandidateID;
import mk.ukim.finki.emt.votingmodule.domain.models.Election;
import mk.ukim.finki.emt.votingmodule.domain.models.ElectionID;
import mk.ukim.finki.emt.votingmodule.domain.repository.ElectionRepository;
import mk.ukim.finki.emt.votingmodule.exceptions.InvalidElectionFormException;
import mk.ukim.finki.emt.votingmodule.service.ElectionService;
import mk.ukim.finki.emt.votingmodule.service.forms.CandidateForm;
import mk.ukim.finki.emt.votingmodule.service.forms.ElectionForm;
import org.springframework.stereotype.Service;

import jakarta.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class ElectionServiceImpl implements ElectionService {
    private final ElectionRepository electionRepository;
   // private final DomainEventPublisher domainEventPublisher;
    private final Validator validator;


    @Override
    public ElectionID createElection(ElectionForm electionForm) throws InvalidElectionFormException {
        Objects.requireNonNull(electionForm,"Election must not be null");
        var constraintValidation = validator.validate(electionForm);
        if (constraintValidation.size()>0){
            throw new InvalidElectionFormException();
        }
        var newElection = electionRepository.saveAndFlush(toDomainObject(electionForm));
        return newElection.getId();
    }

    private Election toDomainObject (ElectionForm electionForm){
        var election = new Election(electionForm.getStartOfElection(),electionForm.getDurationInMinutes());
        electionForm.getFormList().forEach(c -> election.addCandidate(c.getName(),c.getLastname()));
        return election;
    }

    @Override
    public List<Election> findAll() {
        return electionRepository.findAll();
    }

    @Override
    public Optional<Election> findById(ElectionID id) {
        return electionRepository.findById(id);
    }

    @Override
    public void addCandidate(ElectionID id, CandidateForm candidateForm) throws InvalidElectionFormException {
        Election election = electionRepository.findById(id).orElseThrow(InvalidElectionFormException::new);
        election.addCandidate(candidateForm.getName(),candidateForm.getLastname());
        electionRepository.saveAndFlush(election);
    }

    @Override
    public void deleteCandidate(ElectionID electionID, CandidateID candidateID) throws InvalidElectionFormException {
        Election election = electionRepository.findById(electionID).orElseThrow(InvalidElectionFormException::new);
        election.removeCandidate(candidateID);
        electionRepository.saveAndFlush(election);
    }
}
