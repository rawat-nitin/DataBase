package com.example.database.controller

import com.example.database.entity.Account
import com.example.database.entity.Item
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
@RequestMapping("/accounts")

class AccountController(
    @Autowired private val accountRepository: AccountRepository
) {

    @RequestMapping
    fun showAllAccounts(model: Model): String {
        model["title"] = "Accounts page"
        model["accounts"] = accountRepository.findAll().sortedBy { it.id }
        return "accounts"
    }

    @PostMapping("/new")
    fun newAccount(model: Model, @RequestParam name: String, @RequestParam price: String): String {
        Account().apply {
            this.branch = branch
            (accountNumber.toLongOrNull() ?: 0).also { this.accountNumber = it }
            accountRepository.save(this)
        }
        return showAllAccounts(model)
    }

    @RequestMapping("/{id}/items")
    fun itemDetail(model: Model, @PathVariable id: String): String {
        model["title"] = "Account detail"
        model["items"] = accountRepository.findByIdOrNull(id.toLongOrNull())?.items ?: emptySet<Item>()
        return "accounts-items"
    }
}