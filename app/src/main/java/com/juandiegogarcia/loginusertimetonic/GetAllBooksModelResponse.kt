package com.juandiegogarcia.loginusertimetonic

import com.google.gson.annotations.SerializedName

data class GetAllBooksModelResponse(
    @SerializedName("status") val status: String,
    @SerializedName("sstamp")val sstamp: Long,
    @SerializedName("allBooks")val allBooks: AllBooks,
    @SerializedName("createdVNB")val createdVNB: String,
    @SerializedName("req")val req: String
)

data class AllBooks(
    val nbBooks: Int,
    val nbContacts: Int,
    val contacts: List<Contact>,
    val books: List<Book>
)

data class Contact(
    val u_c: String,
    val lastName: String,
    val firstName: String,
    val sstamp: Int,
    val isConfirmed: Boolean
)

data class Book(
    val invited: Boolean,
    val accepted: Boolean,
    val archived: Boolean,
    val showFpOnOpen: Boolean,
    val sstamp: Long,
    val del: Boolean,
    val hideMessage: String,
    val hideBookMembers: String,
    val description: String?,
    val defaultTemplate: String,
    val isDownloadable: Boolean,
    val canDisableSync: Boolean,
    val b_c: String,
    val b_o: String,
    val cluster: String,
    val tags: Any?,
    val langs: Any?,
    val contact_u_c: Any?,
    val nbNotRead: Int,
    val nbMembers: Int,
    val members: List<Member>,
    val fpForm: FpForm,
    val lastMsg: LastMsg,
    val nbMsgs: Int,
    val userPrefs: UserPrefs,
    val ownerPrefs: OwnerPrefs,
    val sbid: Int,
    val lastMsgRead: Long,
    val lastMedia: Int,
    val favorite: Boolean,
    val order: Int
)

data class Member(
    val u_c: String,
    val invite: String,
    val right: Int,
    val access: Int,
    val hideMessage: String,
    val hideBookMembers: String,
    val apiRight: String
)

data class FpForm(
    val fpid: Int,
    val name: String,
    val lastModified: Long
)
data class LastMsg(
    val smid: Long,
    val uuid: String,
    val sstamp: Long,
    val lastCommentId: Long,
    val msgBody: String,
    val msgType: String,
    val msgMethod: String,
    val msgColor: String,
    val nbComments: Int,
    val pid: Int,
    val nbMedias: Int,
    val nbEmailCids: Int,
    val nbDocs: Int,
    val b_c: String,
    val b_o: String,
    val u_c: String,
    val linkedRowId: Any?,
    val linkedTabId: Any?,
    val linkMessage: String,
    val linkedFieldId: Any?,
    val msg: String,
    val del: Boolean,
    val created: Long,
    val lastModified: Long,
    val docs: List<Doc>
)

data class Doc(
    val id: Int,
    val ext: String,
    val originName: String,
    val internName: String,
    val uuid: String,
    val size: Int,
    val type: String,
    val del: Boolean
)

data class UserPrefs(
    val maxMsgsOffline: Int,
    val syncWithHubic: Boolean,
    val uCoverLetOwnerDecide: Boolean,
    val uCoverColor: String,
    val uCoverUseLastImg: Boolean,
    val uCoverImg: String,
    val uCoverType: String,
    val inGlobalSearch: Boolean,
    val inGlobalTasks: Boolean,
    val notifyEmailCopy: Boolean,
    val notifySmsCopy: Boolean,
    val notifyMobile: Boolean,
    val notifyWhenMsgInArchivedBook: Boolean
)

data class OwnerPrefs(
    val fpAutoExport: Boolean,
    val oCoverColor: String,
    val oCoverUseLastImg: Boolean,
    val oCoverImg: String,
    val oCoverType: String,
    val authorizeMemberBroadcast: Boolean,
    val acceptExternalMsg: Boolean,
    val title: String,
    val notifyMobileConfidential: Boolean
)