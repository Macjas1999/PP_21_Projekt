package controllers;

import hibernate.model.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AircraftController {

    @Autowired

    @GetMapping(value = "/aircrafts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Aircraft list(Model model) {
        return ;
    }

    @ApiIgnore

    @RequestMapping(value = "/Aircrafts", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)

    public Iterable<Aircraft> redirect(Model model) {
        return productService.listAllProducts();
    }


    @GetMapping(value = "/Aircrafts/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Aircraft> list(Aircrafts model) {
        return ;
    }

    @GetMapping(value = "/Aircrafts", produces = MediaType.APPLICATION_JSON_VALUE)
    public Aircraft getByParamPublicId(@RequestParam("id") Integer publicId) {
        return productService.getProductById(publicId).orElseGet(null);
    }


    @PostMapping(value = "/product")
    public ResponseEntity<Product> create(@RequestBody @NonNull @Valid
                                                  Product product) {
        product.setProductId(UUID.randomUUID().toString());
        productService.saveProduct(product);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping(value = "/Aircrafts")
    public ResponseEntity<Void> edit(@RequestBody Aircrafts product) {
        if(!productService.checkIfExist(product.getId()))
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            productService.saveProduct(product);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    /**
     * Delete product by its id.
     *
     */
    @DeleteMapping(value = "/Aircrafts/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/Aircrafts/{id}")
    public ResponseEntity deleteBadRequest(@PathVariable Integer id) {
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }


    @GetMapping(value = "/Aircrafts/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> list(@PathVariable("page") Integer pageNr,@RequestParam("size") Optional<Integer> howManyOnPage) {
        return productService.listAllProductsPaging(pageNr, howManyOnPage.orElse(2));
    }

