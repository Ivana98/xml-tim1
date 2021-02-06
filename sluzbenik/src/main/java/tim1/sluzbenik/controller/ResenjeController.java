package tim1.sluzbenik.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xmldb.api.base.XMLDBException;

import tim1.sluzbenik.model.liste.JaxbLista;
import tim1.sluzbenik.model.resenje.ResenjeObrazac;
import tim1.sluzbenik.soap.client.ResenjeClient;
import tim1.sluzbenik.utils.XSLFORTransformer;

import static tim1.sluzbenik.utils.PathConstants.*;

import java.io.File;
import java.io.FileInputStream;

@RestController
@RequestMapping(value = "/resenja")
public class ResenjeController {
  @Autowired
  private ResenjeClient client;

  @GetMapping(path = "/xml", produces = "application/xml")
  public ResponseEntity<JaxbLista<ResenjeObrazac>> findAllFromCollection() throws Exception {

    try {
      JaxbLista<ResenjeObrazac> listaResenje = client.getAllResenje();
      return new ResponseEntity<>(listaResenje, HttpStatus.OK);
    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/generatePDF/{id}")
  public ResponseEntity<byte[]> generatePDF(@PathVariable("id") String id) {

    String file_path = this.transformPDF(id);

    try {
      File file = new File(file_path);
      FileInputStream fileInputStream = new FileInputStream(file);
      return new ResponseEntity<byte[]>(IOUtils.toByteArray(fileInputStream), HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

  }

  @GetMapping("/generateHTML/{id}")
  public ResponseEntity<byte[]> generateHTML(@PathVariable("id") String id) throws XMLDBException {

    String file_path = this.transformHTML(id);

    try {
      File file = new File(file_path);
      FileInputStream fileInputStream = new FileInputStream(file);
      return new ResponseEntity<byte[]>(IOUtils.toByteArray(fileInputStream), HttpStatus.OK);

    } catch (Exception e) {
      e.printStackTrace();
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

  }

  private String transformPDF(String id) {
    XSLFORTransformer transformer = null;

    try {
      transformer = new XSLFORTransformer();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    String doc_str = "";
    try {
      doc_str = this.client.getOne(id);
    } catch (Exception e1) {
      return null;
    }

    boolean ok = false;
    String pdf_path = SAVE_PDF + "resenje_" + id + ".pdf";

    try {
      ok = transformer.generatePDF(doc_str, pdf_path, RESENJE_XSL_FO);
      if (ok)
        return pdf_path;
      else
        return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  private String transformHTML(String id) throws XMLDBException {
    XSLFORTransformer transformer = null;

    try {
      transformer = new XSLFORTransformer();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }

    String doc_str = "";
    try {
      doc_str = this.client.getOne(id);
    } catch (Exception e1) {
      return null;
    }

    boolean ok = false;
    String html_path = SAVE_HTML + "resenje_" + id + ".html";

    try {
      ok = transformer.generateHTML(doc_str, html_path, RESENJE_XSL);
      if (ok)
        return html_path;
      else
        return null;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

}