package mk.ukim.finki.emt.votingmodule.domain.repository;

import mk.ukim.finki.emt.votingmodule.domain.models.Election;
import mk.ukim.finki.emt.votingmodule.domain.models.ElectionID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionRepository extends JpaRepository<Election, ElectionID> {
}
