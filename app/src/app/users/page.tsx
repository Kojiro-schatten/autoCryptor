import Link from "next/link";
import { deleteUserList, getUserList } from "./api";
import Deletebtn from "./Deletebtn";

export default async function UserList() {
  const getUsers = await getUserList();
  console.log("getUserList", getUsers);

  return (
    <>
      {
        getUsers?.users ? (
        getUsers.users.map((user: {id: number, name: string, createdAt: string, updatedAt: string}) => (
          <div key={user.id}>
            <p>{user.id}</p>
            <p>{user.name}</p>
            <p>{user.createdAt}</p>
            <p>{user.updatedAt}</p>
          </div>
        ))
        ) : (
          <>
            <div>現在ユーザーリストが存在しません。</div>
            <div>ユーザーをボタン1つで生成する</div>
          </>

        )
      }
      <Deletebtn>ClickしたらUser id 1が消されるボタン</Deletebtn>
      <Link href="/">Go to Top page</Link>
    </>

  )
}
