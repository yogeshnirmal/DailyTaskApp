package com.neosoft.controller;

import com.neosoft.model.Holiday;
import com.neosoft.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/holiday")
@CrossOrigin("*")
public class HoliidayController {
    @Autowired
    private HolidayService holidayService;

    @PostMapping(value = "/")
    private Holiday saveHoliday(@RequestBody Holiday  holiday) {
        Holiday holidayResp=holidayService.addHoliday(holiday);
        return holidayResp;
    }
    @GetMapping(value = "/{id}")
    private Holiday  getHoliday(@PathVariable Long id) {
        Holiday  holidayResp=holidayService.getHolidayById(id);
        return holidayResp;
    }
    @GetMapping(value = "/")
    private List<Holiday > getAllHoliday() {
        List<Holiday > holidayResp=holidayService.allHoliday();
        return holidayResp;
    }
    @DeleteMapping(value = "/{id}")
    private void deleteHoliday(@PathVariable Long id) {
        holidayService.deleteHoliday(id);
    }
    @PutMapping(value="/{id}")
    private Holiday  updateHoliday(@PathVariable Long id,@RequestBody Holiday  holiday) {
        holiday.setId(id);
       return holidayService.updateHoliday(holiday);
    }

}
