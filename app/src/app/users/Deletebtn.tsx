"use client";

import React, { FunctionComponent, memo, useState } from "react";
import { deleteUserList } from "./api";

interface Props {
  children: React.ReactNode;
}

const Deletebtn: FunctionComponent<Props> = ({ children }) => {
  const [deleteLog, setDeleteLog] = useState('')

  const onDelete = () => {
    deleteUserList(1).then((data: string) => {
      console.log(data)
      setDeleteLog(data)
    })
  }
  return (
    <>
      <button
        onClick={() => {
          onDelete();
        }}
      >
        {children}
      </button>

      {deleteLog && (
        <p style={{color: "red"}}>{deleteLog}</p>
      )}
    </>

  );
};

export default memo(Deletebtn);
