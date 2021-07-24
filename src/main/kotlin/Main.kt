fun main() {


    UserService.addUser(User(name = "Andrew"))
    UserService.addUser(User(name = "Max"))
    UserService.addUser(User(name = "Oleg"))
    UserService.addUser(User(name = "Olga"))
    UserService.addUser(User(name = "Angela"))

    val andrew = UserService.findUserByName("Andrew")
    val max = UserService.findUserByName("Max")
    val oleg = UserService.findUserByName("Oleg")
    val olga = UserService.findUserByName("Olga")
    val angela = UserService.findUser{ user -> user.id == UserService.findUser{it.name == "Angela"}.id}


    ChatService.createMessage(andrew, max, "Привет!")
    ChatService.createMessage(max, andrew, "Хай!")
    ChatService.createMessage(oleg, angela, "Привееет!")
    ChatService.createMessage(angela, oleg, "Драсьте!")
    ChatService.createMessage(max, andrew, "Что делаешь?")
    ChatService.createMessage(oleg, angela, "ЕМ!")
    ChatService.createMessage(angela, oleg, "Приятного аппетита")
    ChatService.createMessage(oleg, angela, "сяп!!!")
    ChatService.createMessage(angela, oleg, "А я чай пью")
    ChatService.createMessage(angela, olga, "Как день прошел?")
    ChatService.createMessage(oleg, angela, "Завтра увидимся!")
    ChatService.createMessage(angela, oleg, "Во сколько?")


    println("\nВсего чатов: ${ChatService.getChatsNumber()}")
    println("Из них нечитанных: ${ChatService.getUnreadChatsCount()}")

    ChatService.deleteChat(ChatService.getChatByUsers(max, andrew))
    println("\nПосле удаления одного из чатов:")
    println("Всего чатов: ${ChatService.getChatsNumber()}")
    println("Из них нечитанных: ${ChatService.getUnreadChatsCount()}")

    println("Количество чатов пользователя ${angela.name}: ${angela.getChatsList().size} ")

    println("\nСообщения пользователей ${angela.name} и ${oleg.name}:\n${ChatService.getMessagesStringByUsers(oleg, angela)}")

}