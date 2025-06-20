package org.naammm.superapp.loosecoupling.di.v3finalfantasy;

public interface NotiService {
    //INTERFACE LÀ 1 CLASS CHA, KHÔNG CÓ CODE TRONG HÀM (ABSTRACT METHOD), SAU NÀ CÓ CODE NHƯNG NÓ LẠ LẮM !!!
    //VỀ LÍ THUYÉT, KO CÓ CODE THÌ TRONG NEW ĐƯỢC OBJECT VÌ NEW XONG, CHẤM GỌ HÀM, HÀM KO CÓ CODE, LẤY GÌ MÀ CHẠY
    public void sendNoti(String recipient, String message);
}
