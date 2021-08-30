package com.example.desafiopwa.api.controllers;

import java.util.*;

import com.example.desafiopwa.api.model.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apps")
public class AppsController {

	private List<Apps> appslist = new ArrayList<>();

	private Integer idcount = 0;

	@GetMapping("/")
	public Apps apps() {
		Apps apps = new Apps();
		return apps;
	}

	@GetMapping("/{id}")
	public Apps apps(@PathVariable("id") Integer id) {

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

	@PutMapping("/{id}")
	public Apps appspost(@PathVariable("id") Integer id, @RequestBody Apps app) {

		Optional<Apps> appFind = appslist.stream().filter(apps -> apps.getId() == id).findFirst();
		if (appFind.isPresent()) {


			appslist.set(id-1, app);
			if (app.getId() == null){
				app.setId(id);
				return app;
			}
			return app;
		}

		return null;
	}

	@DeleteMapping("/{id}")
	public Apps appsdelete(@PathVariable("id") Integer id) {

		Optional<Apps> appFind = appslist.stream().filter(apps -> apps.getId() == id).findFirst();

		if (appFind.isPresent()) {

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
