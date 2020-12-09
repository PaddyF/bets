package com.paddy.bets

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.set
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class BetsFormController {
    @GetMapping("/submitForm")
    fun bettingForm(model: Model): String {
        model["submissionForm"] = BetForm()
        return "submissionForm"
    }

    @PostMapping("/submitForm")
    fun formSubmit(@ModelAttribute submissionForm: BetForm?, model: Model): String? {
        if (submissionForm != null) {
            model["submissionForm"] = submissionForm
        }
        return "formOutput"
    }
}