package org.openg2p.voucherservice.controller

import org.openg2p.voucherservice.models.DiscountVoucher
import org.openg2p.voucherservice.models.GiftVoucher
import org.openg2p.voucherservice.models.VoucherProgram
import org.openg2p.voucherservice.service.VoucherService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping("/api/v1")
class VoucherController constructor(private val voucherService: VoucherService) {

    //Adding Program Details
    @PostMapping("/program")
    fun createProgram(@RequestBody voucherProgram: VoucherProgram): Mono<ResponseEntity<String>> {
        voucherService.createProgram(voucherProgram)
        return Mono.just(ResponseEntity("Program Created Successfully!", HttpStatus.CREATED))
    }
    //Getting all program Details
    @GetMapping("/program")
    fun getAllPrograms(): List<VoucherProgram>
    {
        return voucherService.getAllPrograms()
    }
    //Deleting Program
    @DeleteMapping("/program/{id}")
    fun deleteVoucher(@PathVariable id: Int?): String {
        return voucherService.deleteProgramById(id);
    }
    //Updating Program Details
//    @PutMapping("/program/{id}")
//    fun updateProgram(@PathVariable id:Int?,@RequestBody voucherProgram: VoucherProgram) {
//        return voucherService.updateProgram(id);
//    }

//    Getting Program By Id
//    @GetMapping("/program/{id}")
//    fun getProgramById(@PathVariable id:Int?): Optional<VoucherProgram>
//    {
//        return voucherService.getProgramById(id);
//    }

//    @GetMapping("/program/{program_name}")
//    fun getProgramDetails(@PathVariable program_name: String?): Optional<VoucherProgram> {
//        return voucherService.getProgramByName(program_name);
//    }
//    @PutMapping("/{id}")
//    fun updateVoucher(@RequestBody voucher: Voucher, @PathVariable id: Int?): Mono<Voucher?>? {
//        return voucherService.findById(id)
//            .map { c ->
//                c.setName(voucher.getName())
//                c
//            }.flatMap { c -> repository.save(c) }
//    }

    //Discount Vouchers
    //Create discount Vouchers
    @PostMapping("/voucher/discount")
    fun createDiscountVoucher(@RequestBody voucher: DiscountVoucher):Mono<ResponseEntity<String>>{
        voucherService.createDiscountVoucher(voucher)
        return Mono.just(ResponseEntity("Voucher Created Successfully!", HttpStatus.CREATED))
    }
    //Get all discount vouchers
    @GetMapping("/voucher/discount")
    fun getAllDiscountVouchers(): List<DiscountVoucher>
    {
        return voucherService.getAllDiscountVouchers()
    }
    //Get discount voucher by voucher code
    @GetMapping("/voucher/discount/{voucher_code}")
    fun getDiscountVoucherByCode(@PathVariable voucher_code:String): Any?
    {
        return voucherService.getDiscountVoucherByCode(voucher_code)
    }
    //Redeem discount voucher by code
    @GetMapping("/voucher/discount/redeem")
    fun redeemDiscountVoucherByCode(@RequestBody redeem:Map<String,Any>): Any?
    {
        return voucherService.redeemDiscountVoucherByCode(redeem)
    }

    //Gift Vouchers
    // Create gift voucher
    @PostMapping("/voucher/gift")
    fun createGiftVoucher(@RequestBody voucher: GiftVoucher):Mono<ResponseEntity<String>>{
        voucherService.createGiftVoucher(voucher)
        return Mono.just(ResponseEntity("Voucher Created Successfully!", HttpStatus.CREATED))
    }
    //Get all gift vouchers
    @GetMapping("/voucher/gift")
    fun getAllGiftVouchers(): List<GiftVoucher>
    {
        return voucherService.getAllGiftVouchers()
    }
    //Get gift voucher by voucher code
    @GetMapping("/voucher/gift/{voucher_code}")
    fun getGiftVoucherByCode(@PathVariable voucher_code:String): Any?
    {
        return voucherService.getGiftVoucherByCode(voucher_code)
    }
    //Redeem gift voucher by code
    @GetMapping("/voucher/gift/redeem")
    fun redeemGiftVoucherByCode(@RequestBody redeem:Map<String,Any>): Any?
    {
        return voucherService.redeemGiftVoucherByCode(redeem)
    }
}

