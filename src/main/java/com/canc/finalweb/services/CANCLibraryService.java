package com.canc.finalweb.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.canc.finalweb.dtos.CANCLibraryDto;
import com.canc.finalweb.dtos.interfaces.CANCLibraryMapper;
import com.canc.finalweb.models.CANCLibrary;
import com.canc.finalweb.repositories.CANCLibraryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CANCLibraryService {

    @Autowired
    private CANCLibraryRepository libraryRepository;

    @Transactional
    public Iterable<CANCLibraryDto> getAllLibraries() throws Exception {

        List<CANCLibrary> list = (List<CANCLibrary>) libraryRepository.findAll();

        // Map the list to a list of DTOs
        List<CANCLibraryDto> listDto = list.stream().map(CANCLibraryMapper.INSTANCE::libraryToDto)
                .collect(Collectors.toList());

        return listDto;
    }

    @Transactional
    public CANCLibraryDto getById(Long id) throws Exception {
        CANCLibrary library = libraryRepository.findById(id).orElseThrow(() -> new Exception("Library not found"));
        return CANCLibraryMapper.INSTANCE.libraryToDto(library);
    }

    @Transactional
    public CANCLibrary saveLibrary(CANCLibraryDto library) throws Exception {
        CANCLibrary libraryToSave = CANCLibraryMapper.INSTANCE.dtoToLibrary(library);
        return libraryRepository.save(libraryToSave);
    }

    @Transactional
    public CANCLibrary updateLibrary(CANCLibraryDto library) throws Exception {

        CANCLibrary libraryToUpdate = libraryRepository.findByName(library.getName());

        libraryToUpdate.setName(library.getName());

        return libraryRepository.save(libraryToUpdate);
    }

    @Transactional
    public void deleteLibrary(Long id) throws Exception {

        CANCLibrary libraryToDelete = libraryRepository.findById(id)
                .orElseThrow(() -> new Exception("Library not found"));

        libraryRepository.delete(libraryToDelete);

    }

}
