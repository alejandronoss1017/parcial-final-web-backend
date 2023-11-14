package com.canc.finalweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canc.finalweb.dtos.CANCLibraryDto;
import com.canc.finalweb.models.CANCLibrary;
import com.canc.finalweb.services.CANCLibraryService;

@RestController
@RequestMapping(path = "/api/libraries")
@CrossOrigin(origins = "*")
public class CANCLibraryController {

    @Autowired
    private CANCLibraryService libraryService;

    @GetMapping(path = "/all")
    public ResponseEntity<Iterable<CANCLibraryDto>> getAllLibraries() throws Exception {

        Iterable<CANCLibraryDto> libraries = libraryService.getAllLibraries();

        if (libraries == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libraries);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CANCLibraryDto> getLibraryById(Long id) throws Exception {

        CANCLibraryDto library = libraryService.getById(id);

        if (library == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(library);

    }

    @PostMapping(path = "/save")
    public ResponseEntity<CANCLibrary> saveLibrary(@RequestBody CANCLibraryDto library) throws Exception {

        CANCLibrary librarySaved = libraryService.saveLibrary(library);

        if (librarySaved == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(librarySaved);

    }

    @PutMapping(path = "/update")
    public ResponseEntity<CANCLibrary> updateLibrary(@RequestBody CANCLibraryDto library) throws Exception {

        CANCLibrary libraryUpdated = libraryService.updateLibrary(library);

        if (libraryUpdated == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(libraryUpdated);

    }

    @PostMapping(path = "/delete/{id}")
    public ResponseEntity<Void> deleteLibrary(Long id) throws Exception {

        libraryService.deleteLibrary(id);

        return ResponseEntity.ok().build();
    }
}
