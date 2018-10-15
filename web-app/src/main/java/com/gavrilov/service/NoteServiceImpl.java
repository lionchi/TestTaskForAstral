package com.gavrilov.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class NoteServiceImpl implements  NoteService {

    @PersistenceContext
    private EntityManager entityManager;

}
