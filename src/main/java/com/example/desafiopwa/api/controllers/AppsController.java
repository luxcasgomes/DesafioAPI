package com.example.desafiopwa.api.controllers;

import java.util.*;

import com.example.desafiopwa.api.model.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apps")
public class AppsController {

	private List<Apps> appslist = new ArrayList<>();

	private Long idcount = 0L;

	@GetMapping("/")
	public Apps apps() {
		Apps apps = new Apps();
		return apps;
	}

	@GetMapping("/{id}")
	public Apps apps(@PathVariable("id") Long id) {

		Optional<Apps> appFind = appslist.stream().filter(apps -> apps.getId() == id).findFirst();

		if (appFind.isPresent()) {
			return appFind.get();
		}

		return null;
	}

	@PostMapping("/")
	public Apps apps(@RequestBody Apps apps) {
		this.idcount += 1;
		apps.setId(this.idcount);
		appslist.add(apps);
		return apps;
	}

	@PutMapping("/{id}-{image}-{icon}-{name}-{dev}-{tipo}")
	public Apps appspost( @PathVariable("id") Long id, @PathVariable("name") String name,
			@PathVariable("image") String image, @PathVariable("icon") String icon, @PathVariable("dev") String dev,
			@PathVariable("tipo") String tipo, Apps app) {

		Optional<Apps> appFind = appslist.stream().filter(apps -> apps.getId() == id).findFirst();

		if (appFind.isPresent()) {
			appFind.get().setName("name");
			appFind.get().setImage("sdadasdasd");
			appFind.get().setIcon(icon);
			appFind.get().setDev(dev);
			appFind.get().setTipo(tipo);
			return appFind.get();
		}

		return null;
	}

	@DeleteMapping("/{id}")
	public Apps appsdelete(@PathVariable("id") Long id) {

		Optional<Apps> appFind = appslist.stream().filter(apps -> apps.getId() == id).findFirst();

		if (appFind.isPresent()) {

			for (int i = 0; i < appslist.size(); i++) {
				System.out.print(appslist.get(i).getId() + "\n");
			}

			for (int i = 0; i < appslist.size(); i++) {
				Apps p = appslist.get(i);

				if (p.getId().equals(id)) {

					appslist.remove(p);

					return null;
				}
			}

		}

		return null;
	}

	@GetMapping("/list")
	public List<Apps> list() {
		return appslist;
	}
}
