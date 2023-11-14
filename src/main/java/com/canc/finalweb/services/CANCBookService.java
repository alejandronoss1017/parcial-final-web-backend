package com.canc.finalweb.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canc.finalweb.dtos.CANCBookDto;
import com.canc.finalweb.dtos.interfaces.CANCBookMapper;
import com.canc.finalweb.models.CANCBook;
import com.canc.finalweb.repositories.CANCBookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CANCBookService {

    @Autowired
    private CANCBookRepository bookRepository;

    @Transactional
    public Iterable<CANCBookDto> getAllBooks() throws Exception {

        List<CANCBook> list = (List<CANCBook>) bookRepository.findAll();

        // Map the list to a list of DTOs
        List<CANCBookDto> listDto = list.stream().map(CANCBookMapper.INSTANCE::bookToDto).collect(Collectors.toList());

        return listDto;

    }

    @Transactional
    public CANCBookDto getBookById(Long id) throws Exception {
        CANCBook book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book not found"));

        return CANCBookMapper.INSTANCE.bookToDto(book);
    }

    @Transactional
    public CANCBook saveBook(CANCBookDto book) throws Exception {
        CANCBook bookToSave = CANCBookMapper.INSTANCE.dtoToBook(book);
        return bookRepository.save(bookToSave);
    }

    @Transactional
    public CANCBook updateBook(CANCBookDto book) throws Exception {

        CANCBook bookToUpdate = bookRepository.findByName(book.getName());

        bookToUpdate.setName(book.getName());

        return bookRepository.save(bookToUpdate);
    }

    @Transactional
    public void deleteBook(Long id) throws Exception {
        bookRepository.deleteById(id);
    }
}
