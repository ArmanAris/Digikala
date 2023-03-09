package ir.aris.digikala.data.model


data class ResponseResult<T>(
    val message : String ,
    val data : T , // T: List<Slider>,
    val success: Boolean
)
