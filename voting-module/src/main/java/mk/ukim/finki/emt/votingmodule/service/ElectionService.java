package mk.ukim.finki.emt.votingmodule.service;

import mk.ukim.finki.emt.votingmodule.domain.models.CandidateID;
import mk.ukim.finki.emt.votingmodule.domain.models.Election;
import mk.ukim.finki.emt.votingmodule.domain.models.ElectionID;
import mk.ukim.finki.emt.votingmodule.exceptions.InvalidElectionFormException;
import mk.ukim.finki.emt.votingmodule.service.forms.CandidateForm;
import mk.ukim.finki.emt.votingmodule.service.forms.ElectionForm;

import java.util.List;
import java.util.Optional;

public interface ElectionService {

    ElectionID createElection(ElectionForm electionForm) throws InvalidElectionFormException;

    List<Election> findAll();

    Optional<Election> findById (ElectionID id);

    void addCandidate(ElectionID id, CandidateForm candidateForm) throws InvalidElectionFormException;

    void deleteCandidate(ElectionID electionID, CandidateID candidateID) throws InvalidElectionFormException;
}
