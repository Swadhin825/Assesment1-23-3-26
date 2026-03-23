package org.example.library.repository;

import org.example.library.entity.IssueRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<IssueRecord, Long> {
}